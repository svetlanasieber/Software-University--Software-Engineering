package app.web;

import app.transaction.service.TransactionService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.mapper.DtoMapper;
import app.web.dto.TransactionResult;
import jakarta.servlet.http.HttpSession;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

import static app.security.SessionInterceptor.USER_ID_SESSION_ATTRIBUTE;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    @Autowired
    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getAllTransactions(HttpSession session) {

        UUID userId = (UUID) session.getAttribute(USER_ID_SESSION_ATTRIBUTE);
        User user = userService.getById(userId);

        List<TransactionResult> transactions = transactionService.getAllTransactionsByOwnerId(userId).stream()
                .map(DtoMapper::toTransactionResult)
                .collect(Collectors.toList());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("transactions", transactions);
        modelAndView.setViewName("transactions");

        return modelAndView;
    }
}
