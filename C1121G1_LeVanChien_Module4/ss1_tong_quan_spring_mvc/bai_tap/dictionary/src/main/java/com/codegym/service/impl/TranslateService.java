package com.codegym.service.impl;

import com.codegym.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateService implements ITranslateService {
 public String findByWord(String word){
  Map<String,String> dictionary = new HashMap<>();
  dictionary.put("red","Màu đỏ");
  dictionary.put("violet","Màu tím");
  dictionary.put("orange","Màu cam");
  dictionary.put("white","Màu trắng");
  dictionary.put("black","Màu đen");
  dictionary.put("pink","Màu hồng");
  dictionary.put("yellow","Màu vàng");
  dictionary.put("brown","Màu nâu");
  dictionary.put("green","Màu xanh lá");
  dictionary.put("blue","Màu xanh trời");

  if (dictionary.containsKey(word)){
   return dictionary.get(word);
  } else {
   return "Không tìm thấy!";
  }
 }
}
