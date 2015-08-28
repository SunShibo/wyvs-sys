//package com.wyvs.wp.test;
//
//
//import com.wyvs.wp.entity.TestDO;
//import com.wyvs.wp.util.MemcachedUtil;
//import com.wyvs.wp.util.StringUtils;
//
//public class TestMemcached {
//
//    public static final void main(String[] args){
//
//        TestDO test = new TestDO() ;
//        test.setId(123);
//        MemcachedUtil.put("sun" , "te9st" , 10) ;
//
//        while (true) {
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String value = (String)MemcachedUtil.get("sun") ;
//            if (StringUtils.isEmpty(value)) {
//                System.out.println("null");
//            }else {
//                System.out.println(value);
//            }
//        }
//
//
//    }
//
//}
