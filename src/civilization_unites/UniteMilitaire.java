package civilization_unites;

public abstract class UniteMilitaire extends Unite
{
    int degatsInfliges = 1;
    
    @Override public String toString()
    {
        return this.getClass().getSimpleName() + "\n" + super.toString();
    }
}
