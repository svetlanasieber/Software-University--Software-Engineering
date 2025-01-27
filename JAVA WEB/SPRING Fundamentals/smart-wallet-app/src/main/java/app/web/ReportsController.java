package app.web;

import app.security.RequireAdminRole;
import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.transaction.model.Transaction;
import app.transaction.service.TransactionService;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.model.Wallet;
import app.wallet.service.WalletService;
import app.web.dto.SystemReport;
import app.web.mapper.DtoMapper;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final TransactionService transactionService;
    private final WalletService walletService;

    @Autowired
    public ReportsController(UserService userService,
            SubscriptionService subscriptionService,
            TransactionService transactionService,
            WalletService walletService) {

        this.userService = userService;
        this.subscriptionService = subscriptionService;
        this.transactionService = transactionService;
        this.walletService = walletService;
    }


    @GetMapping
    @RequireAdminRole
    public ModelAndView getSystemReports(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        List<User> users = userService.getAllUsers();
        List<Wallet> wallets = walletService.getAllWallets();
        List<Transaction> transactions = transactionService.getAllTransactions();
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();

        SystemReport systemReports = DtoMapper.mapToSystemReport(users, wallets, transactions, subscriptions);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", user);
        modelAndView.addObject("systemReports", systemReports);
        modelAndView.setViewName("reports");

        return modelAndView;
    }

}
