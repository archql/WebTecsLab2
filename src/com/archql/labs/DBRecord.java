package com.archql.labs;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * class that holds general information of any device in a stock.
 * property <b>quantityBought</b> reflects amount of items being bought
 * property <b>quantity</b> reflects amount of items in stock
 * property <b>lastEdited</b> reflects date and time when the record was edited
 * property <b>status</b> reflects what type of change was done to the record last
 * @version 1.0
 */
public class DBRecord {

    public enum DBRecordStatus{
        Invalid,
        Deleted,
        Created,
        QuantityAdded,
        QuantitySubtracted,
        SubtractionFailed,
        OutOfStock
    }

    /** property <b>quantityBought</b> reflects amount of items being bought */
    public int quantityBought = 0;

    /** property <b>quantity</b> reflects amount of items in stock */
    public int quantity = 0;

    /** property <b>lastEdited</b> reflects date and time when the record was edited */
    public Date lastEdited;

    /** property <b>status</b> reflects what type of change was done to the record last */
    public DBRecordStatus status;

    /**
     * creates empty with status Created. sets last edited time
     */
    public DBRecord()
    {
        lastEdited = new Timestamp(System.currentTimeMillis());
        status = DBRecordStatus.Created;
    }

    /**
     * creates with quantity and status QuantityAdded. sets last edited time
     */
    public DBRecord(int quantity)
    {
        this();
        this.quantity = quantity;
        status = DBRecordStatus.QuantityAdded;
    }

    /**
     * adds quantity. sets status QuantityAdded. sets last edited time
     */
    public void add(int quantity){
        lastEdited.setTime(System.currentTimeMillis());

        this.quantity+= quantity;
        status = DBRecordStatus.QuantityAdded;
    }

    /**
     * subtracts quantity. sets last edited time.
     * @param quantity - amount to subtract
     * @return amount of items subtracted
     * if current quantity less than quantity then sets SubtractionFailed
     * if current quantity became 0 then sets OutOfStock
     * otherwise sets QuantitySubtracted
     */
    public int sub(int quantity){
        lastEdited.setTime(System.currentTimeMillis());

        if (this.quantity < quantity) {
            status = DBRecordStatus.SubtractionFailed;
            return 0;
        }
        this.quantity -= quantity;
        if (quantity == 0)
            status = DBRecordStatus.OutOfStock;
        else
            status = DBRecordStatus.QuantitySubtracted;
        return quantity;
    }
    /**
     * force subtracts quantity. sets last edited time.
     * @param quantity - amount to subtract
     * @return amount of items subtracted
     * if current quantity less than quantity then force subtracts all remaining
     * if current quantity became 0 then sets OutOfStock
     * otherwise sets QuantitySubtracted
     */
    public int subForce(int quantity){
        lastEdited.setTime(System.currentTimeMillis());

        this.quantity -= quantity;
        if (quantity <= 0) {
            status = DBRecordStatus.OutOfStock;
            int subtracted = quantity - this.quantity;
            this.quantity = 0;
            return subtracted;
        }
        status = DBRecordStatus.QuantitySubtracted;
        return quantity;
    }
}
