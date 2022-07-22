package com.example.blog.test;

import com.example.blog.model.RoleType;
import com.example.blog.model.UserM;
import com.example.blog.repository.UserMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class DummyControllerTest {

    @Autowired  //의존성 주입  DI
    private UserMRepository userMRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){

        try {
            userMRepository.deleteById(id);
        } catch (Exception e) {
            return "삭제에 실패하였습니다 해당 ID는 DB에 없습니다";
        }

        return "삭제되었습니다 id:"+id;
    }

    @Transactional // 함수 종료시 자동 commit
    @PutMapping("/dummy/user/{id}")
    public UserM updateUser(@PathVariable int id, @RequestBody UserM requestUserM){
        System.out.println("id:" + id);
        System.out.println("password:"+ requestUserM.getPassword());
        System.out.println("email:" + requestUserM.getEmail());

        // user 가져올때 영속화 (영속성 컨텍스트)
        UserM userM = userMRepository.findById(id).orElseThrow(() ->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        userM.setPassword(requestUserM.getPassword());
        userM.setEmail(requestUserM.getEmail());

        //userRepository.save(user);
        // 더티 체킹
        // 영속성 컨텍스트 set 되고 트랜잭션이 끝나면 update
        return null;
    }
    @GetMapping("/dummy/user")
    public List<UserM> list() {
        return userMRepository.findAll();
    }

    @GetMapping("/dummy/users")
    public List<UserM> pageList(@PageableDefault(size=2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable ){
        Page <UserM> pasingUsers = userMRepository.findAll(pageable);

        List<UserM> userMS = pasingUsers.getContent();
        return userMS;
    }

    @GetMapping("/dummy/user/{id}")
    public UserM detail(@PathVariable int id) {
// 람타식
        UserM userM = userMRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자가 없습니다.");
        });

//        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {  //유저가 없을 경우
//            @Override
//            public IllegalArgumentException get() {
//                return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
//            }
//        });


        return userM;   // 자바오브젝트를 스프링부트 메시지컨버터가 자동 json  변환하여 리턴함
    }

    @PostMapping("/dummy/join")
    public String join(UserM userM) {
        System.out.println("join()");
        System.out.println("username:"+ userM.getUsername()+" id:"+ userM.getId()+" password:"+ userM.getPassword()+" email:"+ userM.getEmail()+" role:"+ userM.getRole()
                +"create:"+ userM.getCreateDate());

        userM.setRole(RoleType.USER);
        userMRepository.save(userM);
        return "회원가입이 완료되었습니다.";
    }
}
