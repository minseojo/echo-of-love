package EchoOfLove.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "sign-up"; // sign-up.html 반환
    }

    @PostMapping("/sign-up")
    public String signUp() {
        // 회원가입 로직 처리
        return "redirect:/sign-in"; // 회원가입 후 로그인 페이지로 이동
    }

    @GetMapping("/sign-in")
    public String signInForm() {
        return "sign-in"; // sign-in.html 반환
    }

    @PostMapping("/sign-in")
    public String signIn() {
        // 로그인 로직 처리
        return "redirect:/profile"; // 로그인 성공 후 프로필 페이지로 이동
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // 예시 데이터
        model.addAttribute("email", "user@example.com");
        model.addAttribute("phone", "010-1234-5678");
        return "profile"; // profile.html 반환
    }

    @PostMapping("/leave")
    public String leave() {
        // 탈퇴 처리 로직
        return "redirect:/goodbye"; // 탈퇴 후 페이지 이동
    }

    @GetMapping("/faqs")
    public String faqs() {
        return "faqs"; // faqs.html 반환
    }
}
