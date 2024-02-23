package com.todaktodak.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.todaktodak.entity.User;

public class userSerializer extends JsonSerializer<User>{

	@Override
	public void serialize(User user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeStartObject();
		gen.writeStringField("userEmail", user.getUserEmail());
        //jsonGenerator.writeStringField("doctorName", user.getDoctorName());
		gen.writeEndObject();
	}

}
