package gal.republica.coego.demiurgo.values;

import java.io.Serializable;

import gal.republica.coego.demiurgo.exceptions.IllegalOperationException;
import gal.republica.coego.demiurgo.exceptions.ValueCastException;
import gal.republica.coego.demiurgo.lib.ReturnValueTypes;
import gal.republica.coego.demiurgo.lib.ValueData;
import gal.republica.coego.demiurgo.universe.World;

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
public interface IReturnValue extends Serializable {
	/**
	 * Returns the result of adding this value to another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue add(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns the result of subtracting another value from this one.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue sub(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns the result of multiply this value to another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue mul(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns the result of divide this value by another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue div(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is equal to another,
	 * or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue eq(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is different from
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue neq(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is greater of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue greq(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue leseq(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is greater than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue great(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public IReturnValue less(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is true and another
	 * one is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue and(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is true or another one
	 * is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue or(IReturnValue another) throws IllegalOperationException;

	/**
	 * Returns the negative of this value.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue negative() throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is false, or value 0
	 * if not.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue not() throws IllegalOperationException;

	/**
	 * Returns the result of a dice roll. This value determines the number of
	 * faces.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue dice() throws IllegalOperationException;

	/**
	 * Returns the result of some dice rolls. This value determines the number
	 * of dices, and the other determines the number of faces.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue multDice(IReturnValue another) throws IllegalOperationException;

	/**
	 * Casts the inner value to an integer value.
	 * 
	 * @return
	 * @throws ValueCastException
	 */
	public int castToInteger() throws ValueCastException;

	/**
	 * Casts the inner value to a float value.
	 * 
	 * @return
	 * @throws ValueCastException
	 */
	public float castToFloat() throws ValueCastException;

	/**
	 * Casts the inner value to a string value.
	 * 
	 * @return
	 * @throws ValueCastException
	 */
	public String castToString() throws ValueCastException;

	/**
	 * Returns true if the value of this object counts as true, false otherwise.
	 * 
	 * @return
	 * @throws ValueCastException
	 */
	public boolean isTrue() throws ValueCastException;

	/**
	 * Checks if the new value can be assigned on this object considering its
	 * type.
	 * 
	 * @param value
	 * @return True if the new value can be assigned, false otherwise.
	 */
	public boolean canAssign(IReturnValue newRValue);

	/**
	 * Assigns a new value without changing type, making the pertinent cast
	 * operations.
	 * 
	 * @param value
	 * @return False if there is not cast operation.
	 */
	public boolean assign(IReturnValue newRValue);

	/**
	 * Returns the value specified by index from a list.
	 * 
	 * @param index
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public IReturnValue getFromIndex(int index) throws IllegalOperationException;

	/**
	 * Returns an object with the same exact value as this one.
	 * 
	 * @return
	 */
	public IReturnValue cloneValue();

	/**
	 * Returns the type from a enum. Useful to check compatibility of types.
	 * 
	 * @return
	 */
	public ReturnValueTypes getType();

	/**
	 * Returns the depth of the list if the value is a list; returns 0
	 * otherwise.
	 * 
	 * @return
	 */
	public int getDepth();

	/**
	 * Sets this variable as writable or not (writable by default).
	 * 
	 * @param writable
	 */
	public void setWritable(boolean writable);

	/**
	 * Rebuild the value. This method must be called after a deserialization.
	 * 
	 * @return The value itself rebuilded.
	 */
	public IReturnValue rebuild(World world);

	/**
	 * Returns an array of 3 strings that codifies the value of this object.
	 * 
	 * @return First string specifies type; 2º string specifies additional type
	 *         info (like class name on objects); 3º string is the real value.
	 */
	public String[] getValueCodes();

	/**
	 * Creates a new ValueData object with this object's value.
	 * 
	 * @return A serializable object ready to be exported.
	 */
	public ValueData valueData();
}
