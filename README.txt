* Update log Assignment - 8/7
- cập nhật thêm cột Status Account và rating ở query
- sửa lỗi sale sản phẩm mới trong store.jsp, thanh toán tiền trong checkout.jsp
- cập nhập property isStatus - để phần admin xóa là chuyển từ trạng thái true-active sang false-Inactive
- Thêm check login xem tài khoản đó status là true hay false
- Thêm phần top rating và top rating của từng thể loại - Hiện số sao dựa trên số lượng rating
- Thêm phần sort by rating và có cập nhật DAO restaurant phần của rating
- Trg modal product có thêm Property rate


* Các phần còn thiếu và sẽ thêm vào sau
- Thiếu trang admin - in Progress
- Thiếu filter
- Thiếu chức năng search sản phẩm
- Chưa hoàn thành phần Lưu hóa đơn khi mua - Đang trong quá trình suy nghĩ
- Chưa thêm phần xem detail sản phẩm ở mục top rating dựa theo từng category riêng ở trong index.jsp
- Ảnh về sau sẽ được chuyển từ ảnh = link online thành ảnh sẽ lưu trong project

* Update log Assignment - 9/7 
-Cập nhật thêm AdminPage
**Lưu ý, chỉ cop phần có Admin phía trước servlet và .jsp, mấy phần khác vứt

- Cập nhật User page:
+ Đã thêm phần xem detail sản phẩm ở mục top rating dựa theo từng category riêng ở trong index.jsp
+ Hoàn thiện được phần lưu lại hóa đơn có các điều kiện để check -> có thêm 2 model mới order detail và order -> trong package DAO có thêm Order DAO
+ có thêm phần cookie ở loginServlet và thêm remove cookie khi logout.
+ fix bug forgetPassword not found
+ thêm search product
+ Trong database có thêm 2 bảng mới là order và order detail - Lưu ý: luôn luôn cập nhật mới database để làm admin và chỉnh sửa các lỗi phát sinh khi làm admin

*Các phần còn thiếu và bug
- Thêm alert hỏi đồng ý mua hóa đơn không
- Thêm hủy hóa đơn và khách hàng có thể xem các hóa đơn của mình và không cho phép hủy đơn nếu đơn đó lâu quá thời gian quy định - có lẽ sẽ thêm or ko thêm vì nó hơi phức tạp
- Bug số lượng hóa đơn sẽ về 0 nếu chọn thanh toán nhưng nó vẫn hiện số lượng > 0
- Có lẽ sẽ thêm cái chức năng user tự xóa tk nhưng sẽ là chuyển từ trạng thái active -> inactive - chỉ có admin có quyền khôi phục lại
- sửa icon
- thiếu filter
- Ảnh về sau sẽ được chuyển từ ảnh = link online thành ảnh sẽ lưu trong project
- Thiếu trang admin - in Progress

Update log 14/7:
- Đã sửa lại 1 vài thiếu sót ở trong bài như delete và recover account, product
- Mới check thấy bên update thiếu action và đã thêm vào
- Sửa lại image thành ảnh lưu trong máy   -  Lưu ý: ko hiểu sao khi load ảnh trg server thì lại bị lỗi, nếu gặp thì vào với quyền admin để update lại ảnh sp
- Chỉnh sửa lại front end 1 chút cho nó đẹp
