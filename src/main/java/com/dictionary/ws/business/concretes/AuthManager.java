package com.dictionary.ws.business.concretes;

import com.dictionary.ws.business.abstracts.UserService;
import com.dictionary.ws.core.SecurityConfiguration.CustomUserDetails;
import com.dictionary.ws.core.SecurityConfiguration.authUser;
import com.dictionary.ws.core.SecurityConfiguration.authUserResponse;
import com.dictionary.ws.dataAccess.abstracts.UserDAO;
import com.dictionary.ws.entities.concretes.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Key;

@Service
public class AuthManager {

@Autowired
    UserService userService;
@Autowired
PasswordEncoder bcryptPasswordEncoder;

@Autowired
UserDAO userDAO;

    public authUserResponse authenticate(authUser authUser) {
          User user= userService.getByUserName(authUser.getUserName());

          if(bcryptPasswordEncoder.matches(authUser.getPassword(), user.getPassword())){

              CustomUserDetails userDetails= new CustomUserDetails(user);
              String token = Jwts.builder().setSubject(""+user.getId()).signWith(SignatureAlgorithm.HS512,
                      TextCodec.BASE64.decode("c2VsYW0=")).compact();
              authUserResponse response = new authUserResponse();
              response.setToken(token);
              response.setUser(userDetails);
return response;
          }
        return null;

    }
    @Transactional
    public UserDetails getUserDetails(String token) {
        JwtParser parser=Jwts.parser().setSigningKey(TextCodec.BASE64.decode("c2VsYW0="));
        try {
            parser.parse(token);
            Claims claims=parser.parseClaimsJws(token).getBody();
            long userid=new Long(claims.getSubject());
            User user =userDAO.getById(userid);
            User actualUser= (User) ((HibernateProxy)user).getHibernateLazyInitializer().getImplementation();
            return new CustomUserDetails(actualUser);
        }
        catch (Exception e){
        e.printStackTrace();;
        }

return null;
    }
}
