package values;

/**
 * This interface provides the methods required to perform operations with any
 * type of value. Any class that implements a basic type in this grammar must
 * implement this interface.
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public interface IReturnValue {
	/**
	 * Returns the result of adding this value to another.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue add(IReturnValue another);

	/**
	 * Returns the result of subtracting another value from this one.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue sub(IReturnValue another);

	/**
	 * Returns the result of multiply this value to another.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue mul(IReturnValue another);

	/**
	 * Returns the result of divide this value by another.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue div(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is equal to another,
	 * or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue eq(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is different from
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue neq(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is greater of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue greq(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue leseq(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is greater than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue great(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 */
	public IReturnValue less(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is true and another
	 * one is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * 
	 */
	public IReturnValue and(IReturnValue another);

	/**
	 * Returns an IntegerValue with value 1 if this value is true or another one
	 * is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * 
	 */
	public IReturnValue or(IReturnValue another);

	/**
	 * Returns the negative of this value.
	 * 
	 * @return
	 * 
	 */
	public IReturnValue negative();

	/**
	 * Returns an IntegerValue with value 1 if this value is false, or value 0
	 * if not.
	 * 
	 * @return
	 * 
	 */
	public IReturnValue not();

	/**
	 * Returns the result of a dice roll. This value determines the number of
	 * faces.
	 * 
	 * @return
	 * 
	 */
	public IReturnValue dice();

	/**
	 * Returns the result of some dice rolls. This value determines the number
	 * of dices, and the other determines the number of faces.
	 * 
	 * @param another
	 * @return
	 * 
	 */
	public IReturnValue multDice(IReturnValue another);

	/**
	 * Returns the result of doing an exponentiation.
	 * 
	 * @param another
	 * @return
	 * 
	 */
	public IReturnValue exponent(IReturnValue another);

	/**
	 * Returns the value specified by index from a list.
	 * 
	 * @param another
	 * @return
	 * 
	 */
	public IReturnValue getFromIndex(IReturnValue another);

	/**
	 * Returns an object with the same exact value as this one.
	 * 
	 * @return
	 */
	public IReturnValue cloneValue();

	/**
	 * Returns true if the value of this object counts as true, false otherwise.
	 * 
	 * @return
	 */
	public boolean isTrue();
	
	/**
	 * Returns the type from a enum. Useful to check compatibility of types. 
	 * 
	 * @return
	 */
	public ReturnValueTypes getType();
	
	/**
	 * Returns the depth of the list if the value is a list; returns 0 otherwise.
	 * @return
	 */
	public int getDepth();

}
