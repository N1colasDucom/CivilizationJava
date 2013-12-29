package civilization_exceptions;

public class RessourcesInsuffisantesException extends Exception
{
    public RessourcesInsuffisantesException()
    {
        super("Ressources manquantes.");
    }
    
    public RessourcesInsuffisantesException(String message)
    {
        super(message);
    }
}
