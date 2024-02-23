package com.todaktodak.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.todaktodak.entity.Diary;

public class diarySerializer extends JsonSerializer<Diary>{

	public void serialize(Diary diary, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeStartObject();
		gen.writeNumberField("diarySeq", diary.getDiarySeq());
        //jsonGenerator.writeStringField("doctorName", user.getDoctorName());
		gen.writeEndObject();
	}
}
