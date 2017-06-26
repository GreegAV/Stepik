package Stepik.MailerPackage;

/**
 * Created by avg-m on 25/06/2017.
 */
public class UntrustworthyMailWorker implements MailService {

    public final MailService unrealMailServices[];
    public final RealMailService realMailService;

    /**
     * Конструктор от массива MailService ( результат вызова processMail
     * первого элемента массива передается на вход processMail второго элемента, и т. д.)
     *
     * @param unrealMailServices
     */
    public UntrustworthyMailWorker(MailService unrealMailServices[]) {

        this.unrealMailServices = unrealMailServices;
        realMailService = new RealMailService();

    }

    public RealMailService getRealMailService() {

        return realMailService;

    }

    @Override
    public Sendable processMail(Sendable mail) {

        for (MailService unrealMailService : unrealMailServices) {
            mail = unrealMailService.processMail(mail);
        }

        return realMailService.processMail(mail);
    }
}
