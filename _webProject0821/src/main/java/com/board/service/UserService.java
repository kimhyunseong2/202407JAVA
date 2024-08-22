package com.board.service;



import com.board.db.*;

public class UserService {
	

    public void writeMsg(String id, String pw, String name)
            throws Exception {

        if (id  == null || id.length()  == 0 ||
            pw   == null || pw.length()   == 0 ||
            name == null || name.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }
      

        UserDto dto = new UserDto();
        dto.setId (id );
        dto.setPw  (pw  );
        dto.setName(name);

        new UserDao().insertUser(dto);
    }
    
    public void updateMsg(
            String id, String pw, String name)
                    throws Exception {

        if (id  == null || id.length()  == 0 ||
            pw   == null || pw.length()   == 0 ||
            name == null || name.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        UserDto dto = new UserDto();
        dto.setId    (id    );
        dto.setPw (pw );
        dto.setName (name);
        new UserDao().updateUser(dto);
    }

    
    	
    public boolean login(String id, String pw) {
        UserDto userDto = new UserDto();
        UserDao userDao = new UserDao();
        userDto.setId(id);
        userDto.setPw(pw);
        int userCount = userDao.isUser(userDto);
        return userCount == 1;
        
        
    }

	public UserDto getUserFind(String id, String pw) {
		UserDto userDto = new UserDto();
		UserDao userDao = new UserDao();
        userDto.setId(id);
        userDto.setPw(pw);
		return userDao.findUser(userDto);
	}


}