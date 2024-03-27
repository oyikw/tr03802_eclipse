<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>素数判断</title>
</head>
<body>
	<%
    int num;
    boolean flag = true;
    String ss = "";

    try {
        num = Integer.parseInt(request.getParameter("num"));
        if (num < 2) {
            flag = false;
        } else {
            for (int i = 2; i < num; i++) {
                boolean fl = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        fl = false;
                        break;
                    }
                }
                if (fl) {
                    ss += i + "、";
                    flag = false;
                }
            }
        }

        if (flag) {
            out.print(num + "不是素数");
        } else {
            out.print(num + "是素数");
            if (!ss.isEmpty()) {
                ss = ss.substring(0, ss.length() - 1);
                out.print("，除了" + num + "之外还有" + ss);
            }
        }
    } catch (NumberFormatException e) {
        out.print("请输入一个有效的数字");
    }
%>

</body>
</html>
