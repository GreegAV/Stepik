package Stepik.MailerPackage;

/**
 * Created by avg-m on 25/06/2017.
 */
public class StolenPackageException extends RuntimeException{

    public StolenPackageException () {
        super("Discovered the theft from the parcel!");
    }

}
