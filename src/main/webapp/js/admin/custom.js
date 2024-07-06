let img = document.getElementById('imageInput');
if (img !== null) {
    img.addEventListener('change', function (event) {
        const file = event.target.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = function (e) {
                const imagePreview = document.getElementById('imagePreview');
                imagePreview.src = e.target.result;
                document.getElementById("avatar").value = e.target.result;
                imagePreview.style.display = 'block';
            };

            reader.readAsDataURL(file);
        } else {
            alert("No file selected");
        }
    });
}