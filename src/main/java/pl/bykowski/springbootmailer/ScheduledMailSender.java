package pl.bykowski.springbootmailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@Component
public class ScheduledMailSender {

    private MailService mailService;

    @Autowired
    public ScheduledMailSender(MailService mailService) {
        this.mailService = mailService;
    }

    @Scheduled(cron = "1 * * * * ?")
    public void sendMail() throws MessagingException {
        mailService.sendMail("ayb01323@cndps.com",
                "Wygrałeś",
                "<b>10zł</b><br>:P", true);
    }
}
