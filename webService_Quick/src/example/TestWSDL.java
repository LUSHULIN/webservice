package example;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestWSDL {
    public static void main(String[] args) {
        // 指定调用WebService的URL（这里是我们发布后点击HelloWorld）
        String url = "http://localhost:8080/services/HelloWorld?wsdl";
        //调用的方法
        String method = "add";
        //调用方法的参数列表
        Object[] parms = new Object[]{2.0,3.0};
        TestWSDL calculateClient = new TestWSDL();
        //调用方法
        String svrAddResult = calculateClient.CallMethod(url, method, parms);

        System.out.println(svrAddResult);

    }

    //实现WebService上发布的服务调用
    public String CallMethod(String url, String method, Object[] args) {
        String result = null;
        Call rpcCall = null;
        try {
            //实例websevice调用实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);
            //执行webservice方法
            double rslt = (double) rpcCall.invoke(args);
            result = String.valueOf(rslt);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
