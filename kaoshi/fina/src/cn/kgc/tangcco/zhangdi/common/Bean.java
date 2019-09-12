package cn.kgc.tangcco.zhangdi.common;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor

public class Bean {
	@NonNull
	private String id,className;
	List<Property> property;
}
