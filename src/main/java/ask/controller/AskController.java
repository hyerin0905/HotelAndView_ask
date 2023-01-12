package ask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ask.dto.AskDto;
import ask.service.AskService;

@Controller
public class AskController {
   
   @Autowired
   private AskService askService;
   
   @GetMapping("/openAskList.do")
   public ModelAndView openAskList() throws Exception {
      ModelAndView mv = new ModelAndView("/askList");
      
      List<AskDto> list = askService.selectAskList();
      mv.addObject("list", list);
      
      return mv;
   }
   
   @GetMapping("/openAskWrite.do")
   public String openAskWrite() throws Exception {
      return "/askWrite";
   }
   
   @PostMapping("/insertAsk.do")
   public String insertAsk(AskDto askDto) throws Exception {
      askService.insertAsk(askDto);
      return "redirect:/openAskList.do";
   }
   
   @GetMapping("/openAskDetail.do")
   public ModelAndView openAskDetail(@RequestParam int askIdx) throws Exception {
      ModelAndView mv = new ModelAndView("/askDetail");
      
      AskDto askDto = askService.selectAskDetail(askIdx);
      mv.addObject("ask", askDto);
      
      return mv;
   }
   
   @PostMapping("/updateAsk.do")
   public String updateAsk(AskDto askDto) throws Exception {
      askService.updateAsk(askDto);
      return "redirect:/openAskList.do";
   }
   
   @PostMapping("/deleteAsk.do")
   public String deleteAsk(AskDto askDto) throws Exception {
      askService.deleteAsk(askDto.getAskIdx());
      return "redirect:/openAskList.do"; 
   }


}