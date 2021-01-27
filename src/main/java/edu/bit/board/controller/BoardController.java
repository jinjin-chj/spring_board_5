package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.service.BoardServiceImpl;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class BoardController {

   private BoardService boardService;
   
   @GetMapping("/list.do")	
   public void list(Model model){
      log.info("list");
      model.addAttribute("list", boardService.getList());
   }
   
   @GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) throws Exception{
		log.info("content_view");
		model.addAttribute("content_view", boardService.get(boardVO.getbId()));
		return "content_view";
	}
   
   @GetMapping("/write_view")
	public String write_view(Model model) {
		log.info("write_view()");
		return "write_view";
	}
   
   @PostMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {
		log.info("write()");
		boardService.writeBoard(boardVO);		
		return "redirect:list";
	}
	
}