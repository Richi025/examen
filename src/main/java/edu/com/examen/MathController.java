package edu.com.examen;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {



	@GetMapping("/linearSearch")
	public String linearSearch(@RequestParam String list, @RequestParam String value) {
		String[] valueList = list.split(",");
		String joinedString = String .join(",", valueList);
		int output = linearSearch(valueList, value);
		return String.format("{\"operation\": \"linearSearch\", \"intputList\": \"%s\", \"value\": \"%s\", \"output\": %d}", joinedString, value, output);
	}

	@GetMapping("/binarySearch")
	public String binearSearch(@RequestParam String list, @RequestParam String value) {
		String[] valueList = list.split(",");
		int[] numbers = new int[valueList.length];
		for(int i= 0; i < valueList.length; i++){
			numbers[i] = Integer.parseInt(valueList[i]);
		}
		String joinedString = String .join(",", valueList);
		int output = binarySearch(numbers, Integer.parseInt(value));
		return String.format("{\"operation\": \"binearSearch\", \"intputList\": \"%s\", \"value\": \"%s\", \"output\": %d}", joinedString, value, output);
	}


	private int linearSearch(String[] valuelist, String value) {
		for (int i = 0; i < valuelist.length; i++) {
            if (value.equals(valuelist[i])) {
                return i;
            }
        }    
		return -1;
    }

    private int binarySearch(int[] valuelist, int value) {
		int left = 0;
		int right = valuelist.length - 1;
		while (left <= right){
		    int mid = left + (right - left) / 2;
            if (valuelist[mid] == value){
                return mid;
            }else if(valuelist[mid] < value){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return-1;
    }
}




