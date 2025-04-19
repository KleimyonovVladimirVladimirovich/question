package reg.project.bot.bot;



import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import reg.project.bot.config.TelegramProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import reg.project.bot.service.DispatcherUpd;


//
// ---> Ошибка в конструкторе, весь стэковерфлоу перелазил, но скорее всего ошибка такая глупая, а я на нее несколько дней убил.
//

@Component
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public final class Bot extends TelegramWebhookBot {

     TelegramProperties properties;
     DispatcherUpd upd;

    public Bot(TelegramProperties properties, DispatcherUpd upd) {
        super(properties.getToken());
        this.properties = properties;
        this.upd = upd;
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return upd.distribute(update);
    }

    @Override
    public String getBotPath() {
        return properties.getUrl();
    }

    @Override
    public String getBotUsername() {
        return properties.getName();
    }
}
