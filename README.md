# Project2
This is project 2

1. đồng bộ source code xuống thư mục
   git clone https://github.com/trinhthianh1273/Project2.git
2.  Tạo thư mục mới khởi tạo đưa vào server local sau đó mới đưa lên server trực tuyến (remote) của GIT
    2.1: Tạo 1 thư mục mới để chứa tài nguyên làm việc, sau đó di chuyển vào thư mục đó bằng dòng lệnh
    git init

    2.2: Thực hiện thêm 1 file vào trong server local của GIT
    git add "demo.txt"
    
    2.3: Thực hiện lưu thay đổi vào server local
    git commit -m "Tao moi file";
    
    2.4: Thực hiện đưa tài nguyên lên server online (remote)
    git remote add origin https://github.com/trinhthianh1273/Project2.git

3. thực hiện đưa lên nhánh master: git push -u origin master

4. kiểm tra branch đang thực hiện: git branch
5. tạo 1 branch mới: git branch <branchname>
6. chuyển branch: git chechout <branchname>
7. xóa thông tin 1 branch: git branch -d <branchname>
8. vd thực hiện merge develop -> master: 
    git checkout master
    Switched to branch 'master'
    git merge develop 


II. Sử dụng với MySQL
1. SELECT DATE_FORMAT('2013-11-26 01:24:34', '%Y-%m-%d');
> 2013-11-26
2.