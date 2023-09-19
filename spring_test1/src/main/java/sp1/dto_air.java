package sp1;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dto_air {
	private String pid,pname,ppnumber,pnumber,pcorp,pplane_number,preserve,pmoney;
	public ArrayList<String> listdata(){
		ArrayList<String> list = new ArrayList<>();
		list.add(getPid());
		list.add(getPname());
		list.add(getPpnumber());
		list.add(getPnumber());
		list.add(getPcorp());
		list.add(getPplane_number());
		list.add(getPreserve());
		list.add(getPmoney());
		return list;
	}
	
}
