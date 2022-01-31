package mk.ukim.finki.userservice.service;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.userservice.VO.Fuel;
import mk.ukim.finki.userservice.VO.ResponseTemplateVO;
import mk.ukim.finki.userservice.entity.User;
import mk.ukim.finki.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserController");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithFuel(String username) {
        log.info("Inside getUserWithFuel of UserController");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUsername(username);

        Fuel fuel =
                restTemplate.getForObject("http://localhost:9091/fuels/" + user.getFuelId()
                        , Fuel.class);

        vo.setUser(user);
        vo.setFuel(fuel);

        return vo;
    }
}
