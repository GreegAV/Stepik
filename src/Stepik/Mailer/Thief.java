package Stepik.Mailer;

/**
 * Created by avg-m on 25/06/2017.
 */
public class Thief implements MailService {

    private final int minCostPackage;
    private int stolenValue;

    public Thief(final int minCostPackage) {

        this.minCostPackage = minCostPackage;
        this.stolenValue = 0;

    }

    /**
     * Воровство происходит следующим образом: вместо посылки,
     * которая пришла вору, он отдает новую, такую же, только
     * с нулевой ценностью и содержимым посылки "stones instead of {content}".
     *
     * @param mail - пересылаемая посылка
     * @return mail - подменённая посылка.
     */
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

    int getStolenValue() {
        return stolenValue;
    }
}