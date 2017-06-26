package Stepik.MailerPackage;

/**
 * Created by avg-m on 25/06/2017.
 */
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }

}