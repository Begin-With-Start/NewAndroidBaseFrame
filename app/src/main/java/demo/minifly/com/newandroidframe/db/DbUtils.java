package demo.minifly.com.newandroidframe.db;

public class DbUtils {

//    //插入单个数据
//    public static void addContainer(ContainerBean containerBean, Context context) {
//        SqliteDBHelper dbHelper = null;
//        SQLiteDatabase db = null;
//        try {
//            dbHelper = new SqliteDBHelper(context);
//            db = dbHelper.getWritableDatabase();
//            // 数据对象， 相当于一个Map，把要插入的列写入里面就直接能插入数据库， values里面对应数据库的某个列
//            ContentValues values = new ContentValues();
//            values.put("containerCode", containerBean.getContainerCode());
//            values.put("containerUkid", containerBean.getContainerUkid());
//            values.put("proxyId" , containerBean.getProxyId());
//            // 第一个参数是表名， 第二个参数是如果某个列没有插入值的默认值， 第三个参数是要插入的数据
//            db.insert("containers", "", values);
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                db.close();
//                dbHelper.close();
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    //删除单个数据
//    public static void deleteOneContainer(String code , Context context) {
//        SqliteDBHelper dbHelper = null;
//        SQLiteDatabase db = null;
//        try {
//            dbHelper = new SqliteDBHelper(context);
//            db = dbHelper.getWritableDatabase();
//            db.delete("containers", "containerCode=?", new String[]{code});
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                db.close();
//                dbHelper.close();
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    //删除数据
//    public static void delContainer(Context context) {
//        SqliteDBHelper dbHelper = null;
//        SQLiteDatabase db = null;
//        //所有行删除 表结构依然存在
//        String sql = "delete from containers";
//        try {
//            dbHelper = new SqliteDBHelper(context);
//            db = dbHelper.getWritableDatabase();
//            db.execSQL(sql);
//        } catch (Exception e) {
//        } finally {
//            try {
//                db.close();
//                dbHelper.close();
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    //查找全部数据
//    public static ArrayList<ContainerBean> getAllContainers(Context context) {
//        SqliteDBHelper dbHelper = null;
//        SQLiteDatabase db = null;
//        Cursor cursor = null;
//        String sql = "select * from containers";
//        ArrayList<ContainerBean> containerBeanArrayList = null;
//        try {
//            dbHelper = new SqliteDBHelper(context);
//            db = dbHelper.getReadableDatabase();
//            cursor = db.rawQuery(sql, null);
//            containerBeanArrayList = new ArrayList<>();
//            while (cursor.moveToNext()) {
//                ContainerBean containerBean = new ContainerBean();
//                containerBean.setContainerCode(cursor.getString(cursor.getColumnIndex("containerCode")));
//                containerBean.setContainerUkid(cursor.getString(cursor.getColumnIndex("containerUkid")));
//                containerBean.setProxyId(cursor.getString(cursor.getColumnIndex("proxyId")));
//                containerBeanArrayList.add(containerBean);
//            }
//            return containerBeanArrayList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                cursor.close();
//                db.close();
//                dbHelper.close();
//            } catch (Exception e) {
//            }
//        }
//        return null;
//    }
}
