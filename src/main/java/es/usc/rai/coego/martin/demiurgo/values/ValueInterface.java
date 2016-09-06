package es.usc.rai.coego.martin.demiurgo.values;

import java.io.Serializable;

import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.World;

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
public interface ValueInterface extends Serializable {
	/**
	 * Returns the result of adding this value to another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface add(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns the result of subtracting another value from this one.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns the result of multiply this value to another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns the result of divide this value by another.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface div(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is equal to another,
	 * or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is different from
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is greater of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser of equal to
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is greater than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface great(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is lesser than
	 * another, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 */
	public ValueInterface less(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is true and another
	 * one is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface and(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is true or another one
	 * is true too, or value 0 if not.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface or(ValueInterface another) throws IllegalOperationException;

	/**
	 * Returns the negative of this value.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface negative() throws IllegalOperationException;

	/**
	 * Returns an IntegerValue with value 1 if this value is false, or value 0
	 * if not.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface not() throws IllegalOperationException;

	/**
	 * Returns the result of a dice roll. This value determines the number of
	 * faces.
	 * 
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface dice() throws IllegalOperationException;

	/**
	 * Returns the result of some dice rolls. This value determines the number
	 * of dices, and the other determines the number of faces.
	 * 
	 * @param another
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException;

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
	public boolean canAssign(ValueInterface newRValue);

	/**
	 * Assigns a new value without changing type, making the pertinent cast
	 * operations.
	 * 
	 * @param value
	 * @return False if there is not cast operation.
	 */
	public boolean assign(ValueInterface newRValue);

	/**
	 * Returns the value specified by index from a list.
	 * 
	 * @param index
	 * @return
	 * @throws IllegalOperationException
	 * 
	 */
	public ValueInterface getFromIndex(int index) throws IllegalOperationException;

	/**
	 * Returns an object with the same exact value as this one.
	 * 
	 * @return
	 */
	public ValueInterface cloneValue();

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
	public ValueInterface rebuild(World world);

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
	 * @return A JSON value with 3 fields: value as string, type, and class (optional).
	 */
	public ObjectNode toJSON();
}
