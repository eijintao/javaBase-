package com.java.base.basenum;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class   EnumStatus {


//        SN(1,"sN","少年"),
//                QSN(2,"qsN","青少年"),
//                ZN(3,"zN","中年"),
//                ZLN(4,"zlN","中老年"),
//                LN(5,"lN","老年"),
//                QN(6,"qN","青年");

    public static final String sn = "sN";
    public static final String qsn = "qsN";
    public static final String zn = "zN";
    public static final String zln = "zlN";
    public static final String ln = "lN";
    public static final String qn = "qN";

        private Integer code;

        private  String name;

        private String description;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        EnumStatus(Integer code, String name, String description) {
            this.code = code;
            this.name = name;
            this.description = description;
        }

        EnumStatus(Integer code, String name) {
            this.code = code;
            this.name = name;
        }


}





enum EDbVendor {
    dbvmssql,
    dbvoracle,
    dbvmysql,
    dbvaccess,
    dbvgeneric,
    dbvdb2,
    dbvsybase,
    dbvinformix,
    dbvpostgresql,
    dbvfirebird,
    dbvmdx,
    dbvteradata,
    dbvnetezza,
    dbvansi,
    dbvodbc,
    dbvhive,
    dbvgreenplum,
    dbvredshift,
    dbvimpala,
    dbvhana,
    dbvdax,
    dbvvertica,
    dbvopenedge,
    dbvcouchbase,
    dbvsnowflake;

    private EDbVendor() {
    }
}
