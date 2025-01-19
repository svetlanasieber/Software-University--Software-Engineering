package app.web;

import app.transaction.model.Transaction;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.service.WalletService;
import app.web.mapper.DtoMapper;
import app.web.dto.TransferRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
@RequestMapping("/transfers")
public class TransferController {

    private final UserService userService;
    private final WalletService walletService;

    public TransferController(UserService userService, WalletService walletService) {

        this.userService = userService;
        this.walletService = walletService;
    }

    @GetMapping
    public ModelAndView getTransferPage(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("transferRequest", new TransferRequest());
        modelAndView.setViewName("transfer");

        return modelAndView;
    }

    @PostMapping
    public ModelAndView initiateTransfer(@Valid TransferRequest transferRequest, HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        Transaction transaction = walletService.transferFunds(user, transferRequest);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("transactionResult", DtoMapper.toTransactionResult(transaction));
        modelAndView.setViewName("transaction-result");

        return modelAndView;
    }

}
