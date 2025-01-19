package app.web;

import app.transaction.model.Transaction;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.service.WalletService;
import app.web.mapper.DtoMapper;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
@RequestMapping("wallets")
public class WalletController {

    private final WalletService walletService;
    private final UserService userService;

    @Autowired
    public WalletController(WalletService walletService, UserService userService) {

        this.walletService = walletService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getWallets(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        Map<UUID, List<Transaction>> walletTransactions = walletService.getLastFourTransactionsForWallets(user.getWallets());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("lastFourTransactions", walletTransactions);
        modelAndView.setViewName("wallets");

        return modelAndView;
    }

    @PostMapping
    public String createNewWallet(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        walletService.createNewWallet(user, false);

        return "redirect:/wallets";
    }

    @PutMapping("/{walletId}/balance")
    public ModelAndView topUpWallet(@PathVariable UUID walletId, @RequestParam("top-up-amount") BigDecimal topUpAmount, HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        Transaction transaction = walletService.topUp(walletId, topUpAmount);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("transactionResult", DtoMapper.toTransactionResult(transaction));
        modelAndView.setViewName("transaction-result");

        return modelAndView;
    }

    @PutMapping("/{walletId}")
    public String switchWalletStatus(@PathVariable UUID walletId, HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);

        walletService.switchStatus(userId, walletId);

        return "redirect:/wallets";
    }
}
