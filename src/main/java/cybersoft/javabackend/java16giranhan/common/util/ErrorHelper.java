package cybersoft.javabackend.java16giranhan.common.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ErrorHelper {
	public static List<String> getAllError(BindingResult result){
		return   result.getAllErrors()
				.stream().map(t-> t.getDefaultMessage())
				.collect(Collectors.toList());
	}
}
