package reg.project.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class DispatcherUpd {

    public BotApiMethod<?> distribute(Update update) {
        throw new UnsupportedOperationException();
    }
}
