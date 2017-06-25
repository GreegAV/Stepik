package Stepik;

/**
 Проходит проверку решения.
 */

public class Mailer {

    public static class Thief implements MailService {

        private final int minCostPackage;
        private static int stolenValue;

        public Thief(final int minCostPackage) {

            this.minCostPackage = minCostPackage;
            this.stolenValue = 0;

        }


        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                int priceOfPackage = ((MailPackage) mail).getContent().getPrice();
                if (priceOfPackage >= minCostPackage) {
                    stolenValue += priceOfPackage;
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " +
                            ((MailPackage) mail).getContent().getContent(), 0));
                }
            }

            return mail;
        }

        public static int getStolenValue() {
            return stolenValue;
        }
    }

    public static class Inspector implements MailService {

        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";

        /**
         * Если он заметил запрещенную посылку с одним из запрещенных
         * содержимым ("weapons" и "banned substance"), то он бросает
         * IllegalPackageException. Если он находит посылку, состоящую
         * из камней (содержит слово "stones"), то тревога прозвучит
         * в виде StolenPackageException.
         * @param mail - проверяемое почтовое отправление;
         * @return mail - проверенное почтовое отпрпвление.
         */
        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                String contentOfPackage = ((MailPackage)mail).getContent().getContent();

                if (contentOfPackage.contains("stones")) {
                    throw new StolenPackageException();
                } else if (contentOfPackage.contains(WEAPONS) | contentOfPackage.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
            }
            return mail;
        }
    }
    public static class Spy implements MailService {

        private final Logger logger;
        public static final String AUSTIN_POWERS = "Austin Powers";

        public Spy (Logger logger) {

            this.logger = logger;
            this.logger.setLevel(Level.INFO);
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter());
            this.logger.addHandler(consoleHandler);
        }

        /**
         * Он следит только за объектами класса MailMessage и пишет в логгер
         * следующие сообщения (в выражениях нужно заменить части в фигурных
         * скобках на значения полей почты):
         * 2.1) Если в качестве отправителя или получателя указан "Austin Powers",
         *      то нужно написать в лог сообщение с уровнем WARN:
         *      Detected target mail correspondence: from {from} to {to} "{message}"
         * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO:
         *      Usual correspondence: from {from} to {to}
         * @param mail - пересылаемое отправление.
         * @return mail - пересылаемое отправление после обработки.
         */
        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) | mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING,"Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[] {mail.getFrom(),
                                    mail.getTo(),
                                    ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[] {mail.getFrom(),
                                    mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

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

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException () {
            super("In the package discovered forbidden content.");
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException () {
            super("Discovered the theft from the parcel!");
        }
    }

}
