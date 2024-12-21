/**
 * 
 */
$(document).ready(function() {
	$.ajax({
		url: '/home',
		method: 'GET',
		success: function(response) {
		},
		error: function(xhr) {
		}
	});
	$.ajax({
		url: '/account/detail/',
		type: 'GET',
		success: function(data) {
			$('#user-name').text(data.fullName || 'Unknown User');

			if (data.role === "QUANTRI") {
				$('#user-role').text("Quản trị viên")
			} else if (data.role === "NHANVIEN") {
				$('#user-role').text("Nhân viên")
			} else if (data.role === "QUANLY") {
				$('#user-role').text("Quản lý")
			} else if (data.role === "KHACHHANG") {
				$('#user-role').text("Khách hàng")
			} else {
				$('#user-role').text("Unknown Role")
			}
		},
		error: function(xhr) {
			if (xhr.status === 401) {
				alert("Bạn chưa đăng nhập");
				window.location.href = xhr.responseText;
			}

		}
	});
	$(document).ready(function() {
		// Khi người dùng nhấn vào nút logout
		$('#logout').on('click', function() {
			console.log("Logging out...");

			// Gửi yêu cầu POST để logout
			$.ajax({
				url: '/auth/logout', // Đảm bảo URL chính xác
				method: 'POST', // Phương thức POST
				success: function(response) {
					console.log("Logout successful");
					window.location.href = response; // Điều hướng đến trang login sau khi logout
				},
				error: function(xhr) {
					alert('Đăng xuất thất bại: ' + xhr.responseText); // Hiển thị lỗi nếu có
				}
			});
		});
	});
});

