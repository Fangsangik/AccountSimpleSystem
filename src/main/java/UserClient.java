import com.zerobase.heart.ApplicationConfig;
import com.zerobase.heart.dto.PayCancelRequest;
import com.zerobase.heart.dto.PayCancelResponse;
import com.zerobase.heart.dto.PayRequest;
import com.zerobase.heart.dto.PayResponse;
import com.zerobase.heart.service.ConveniencePayService;
import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService = ac.getBean("conveniencePayService", ConveniencePayService.class);


        System.out.println("== 성공 ==");

        //결제 1000원
        PayRequest request = new PayRequest(ConveienceType.G25, 10, PayMethodType.Card);
        PayResponse response = conveniencePayService.pay(request);

        System.out.println("response = " + response);

        System.out.println("== 취소 ==");

        //취소 500
        PayCancelRequest request1 = new PayCancelRequest(ConveienceType.G25, 500, PayMethodType.Money);
        PayCancelResponse response1 = conveniencePayService.cancelPay(request1);

        System.out.println("response1 = " + response1);
    }
}
