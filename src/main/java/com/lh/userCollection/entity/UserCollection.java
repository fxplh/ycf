package com.lh.userCollection.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCollection implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_collection.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_collection.fk_user_id
     *
     * @mbg.generated
     */
    private String fkUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_collection.fk_food_id
     *
     * @mbg.generated
     */
    private String fkFoodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_collection.collectionDate
     *
     * @mbg.generated
     */
    private Date collectiondate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_collection
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_collection.id
     *
     * @return the value of user_collection.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_collection.id
     *
     * @param id the value for user_collection.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_collection.fk_user_id
     *
     * @return the value of user_collection.fk_user_id
     *
     * @mbg.generated
     */
    public String getFkUserId() {
        return fkUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_collection.fk_user_id
     *
     * @param fkUserId the value for user_collection.fk_user_id
     *
     * @mbg.generated
     */
    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId == null ? null : fkUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_collection.fk_food_id
     *
     * @return the value of user_collection.fk_food_id
     *
     * @mbg.generated
     */
    public String getFkFoodId() {
        return fkFoodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_collection.fk_food_id
     *
     * @param fkFoodId the value for user_collection.fk_food_id
     *
     * @mbg.generated
     */
    public void setFkFoodId(String fkFoodId) {
        this.fkFoodId = fkFoodId == null ? null : fkFoodId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_collection.collectionDate
     *
     * @return the value of user_collection.collectionDate
     *
     * @mbg.generated
     */
    public Date getCollectiondate() {
        return collectiondate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_collection.collectionDate
     *
     * @param collectiondate the value for user_collection.collectionDate
     *
     * @mbg.generated
     */
    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_collection
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fkUserId=").append(fkUserId);
        sb.append(", fkFoodId=").append(fkFoodId);
        sb.append(", collectiondate=").append(collectiondate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}