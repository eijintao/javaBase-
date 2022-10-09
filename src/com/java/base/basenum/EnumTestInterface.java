package com.java.base.basenum;

/**
 * asus 梅锦涛
 * 2022/7/15
 *
 * @author mjt
 */
public interface EnumTestInterface {


    /*
        根据连接名称得到对应的sql解析类型,默认为oracle
         */
    default EDbVendor getAnalyType(String dbtype) {
        return EDB_VENDOR.DEFAULT.getEDbVendorForName(dbtype).edbVendor;
    }

    enum EDB_VENDOR {

        MYSQL("01","mysql",EDbVendor.dbvmysql),
        ORACLE("02","oracle",EDbVendor.dbvoracle),
        SQLSERVER("10","sqlserver",EDbVendor.dbvmssql),
        HIVE("06","hive",EDbVendor.dbvhive),
        POSTGRESQL("03","postgresql",EDbVendor.dbvpostgresql),//关联关系暂不支持解析该数据库类型(2020/5/25)
        GREENPLUM("05","greenplum",EDbVendor.dbvgreenplum),//关联关系暂不支持解析该数据库类型(2020/5/25)
        INCEPTOR("96", "inceptor", EDbVendor.dbvoracle),//语法与oracle一致
        DB2("04", "db2", EDbVendor.dbvdb2),
        DEFAULT("02","oracle",EDbVendor.dbvoracle);

        private String code;

        private String name;

        private EDbVendor edbVendor;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public EDbVendor getEdbVendor() {
            return edbVendor;
        }


        EDB_VENDOR() { }

        EDB_VENDOR(String code,String name,EDbVendor edbVendor) {
            this.code = code;
            this.name = name;
            this.edbVendor = edbVendor;
        }

        public EDB_VENDOR getEDbVendorForName(String name) {
            name = name.toLowerCase();
            name = name.replace("connector","");
            if(name.contains("hive2")){
                name = "hive";
            }
            EDB_VENDOR[] edbVendors = values();
            for (int i = 0; i < edbVendors.length; i++) {
                EDB_VENDOR edbVendor = edbVendors[i];
                if(edbVendor.name.equals(name)) {
                    return edbVendor;
                }
            }
            return EDB_VENDOR.ORACLE;
        }

        public EDB_VENDOR getEDbVendorForCode(String code) {
            EDB_VENDOR[] edbVendors = values();
            for (int i = 0; i < edbVendors.length; i++) {
                if (edbVendors[i].getCode().equals(code)) {
                    return edbVendors[i];
                }
            }
            return null;
        }

        public static void main(String[] args) {
            int i = 9;
            i -= 1;
            System.out.println("i= " + i);
            EDB_VENDOR mysql = EDB_VENDOR.DEFAULT.getEDbVendorForName("mysql");
            System.out.println(mysql.code+","+mysql.name+","+mysql.edbVendor);
        }

    }

}
