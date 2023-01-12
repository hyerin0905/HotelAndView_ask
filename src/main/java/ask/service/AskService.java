package ask.service;

import java.util.List;

import ask.dto.AskDto;

public interface AskService {
   public List<AskDto> selectAskList() throws Exception;
   public void insertAsk(AskDto askDto) throws Exception;
   public AskDto selectAskDetail(int askIdx) throws Exception;
   void updateAsk(AskDto askDto) throws Exception;
   void deleteAsk(int askIdx) throws Exception;

}