package com.example.Hospital.Exceptions;

import org.json.simple.JSONObject;

public class HospitalExceptions extends RuntimeException{

    public enum ERR_CODE {
        LINE_NAME_ALREADY_EXIST(420),
        LINE_COULD_NOT_PERFORM_DELETE_OPERATION(421),
        NOT_AUTHORIZED(401),
        PLANNING_DELETE_ERROR(422),
        SCHEDULING_DELETE_ERROR(423),
        BUYER_PO_NOT_SCHEDULED(424),
        LINE_TRASFERRED_FAILED(425),
        MATERIAL_QUANTITY_NOT_AVAILABLE(426),
        DEPENDENT_MATERIAL_NOT_FREE(427),
        MATERIAL_NOT_FOUND_IN_STORE(428),
        EDIT_LOAD_FAILED(429),
        LINE_LOAD_DELETE_FAILED(430),
        HOURS_ARE_MORE_THAN_LINE(431),
        HOURS_NOT_ADJUSTED(432),
        PRODORDER_LOAD_IS_LESS(433),
        DAY_QTY_NOT_ADJUSTED(434),
        ALREADY_LOAD_AVAILABLE(435),
        DEPENDENT_MATERIAL_NOT_AVAILABLE_INSAP(436),
        DEPENDENT_MATERIAL_NOT_AVAILABLE_INVIR(437),
        MESSAGE_EXCEPTION(438),
        UNSUPPORT_ENCODING_EXCEPTION(439),
        USER_NOT_FOUND(440),
        GRN_AMOUNT_LOW(441),
        GRN_QTY_LOW(442),
        LINK_EXPIRE(449),
        LOADQTY_LESS_THAN_CONFQTY(441),
        MATERIAL_ID_NOT_FOUND(443),
        PLANT_IS_NOT_SELECT(444),
        UNIT_IS_NOT_SELECT(445),
        VIRTUAL_STORE_IS_UPDATED(446),
        LOAD_TABLE_IS_UPDATED(447),
        STORE_LOCATION_MISMATCH(450),
        MOEP_SAP_CONFIRMATION_FAILED_PLEASE_CHECK_IN_SAP(451),
        LOADQTY_MORE_THAN_SCHEDULEQTY(452),
        WRONG_YS_NUMBER(453),
        CHANGE_IN_BOM(454),
        YS_NUMBER_MISSING(455),
        FIVE_MIN_BATCH_RUNNING(456),
        THERE_IS_LOCK_PLEASE_TRY_AFTER_SOMETIME(457),
        SOMETHING_GOING_WRONG_PLEASE_TRY_AFTER_SOMETIME(458),
        BOM_AND_PRODORDER_MISMATCH(459),
        SHADE_APPROVAL_MISSING(460),
        THAN_SPLIT_ERROR(461),
        INSPECTION_NOT_FOUND(462),
        THAN_MANDATE(463),
        TABLE_ASSIGNEE_ERROR(464),
        INSPECTION_ERROR(465);

        ERR_CODE(Integer error) {
            this.error = error;
        }

        private Integer error;
        public Integer getCode() {
            return this.error;
        }
    }

    private ERR_CODE errCode;

    private String errorMssg;

    public String getErrorMssg() {
        return errorMssg;
    }

    public void setErrorMssg(String errorMssg) {
        this.errorMssg = errorMssg;
    }

    public ERR_CODE getErrCode() {
        return errCode;
    }

    public void setErrCode(ERR_CODE errCode) {
        this.errCode = errCode;
    }

    public JSONObject getJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errorCode", this.errCode.getCode());
        return jsonObject;
    }

    public JSONObject getJSONWithMessage() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errorCode", this.errCode.getCode());
        jsonObject.put("message",this.getErrorMssg());
        return jsonObject;
    }

}
