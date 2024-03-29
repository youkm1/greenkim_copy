package com.example.greenkim

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class CheckPostActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private val TAKE_PICTURE_REQUEST = 2

    private val uploadedImages = mutableListOf<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_post)

        val addImage = findViewById<ImageView>(R.id.add_image)
        val imageContainer = findViewById<LinearLayout>(R.id.image_container)

        // 이미지뷰 클릭 이벤트 설정
        addImage.setOnClickListener {
            showImageSourceDialog()
        }

        val boardSpinner = findViewById<Spinner>(R.id.checkboardSpinner)

        // 드롭다운 메뉴 설정
        val boardOptions = arrayOf("전자영수증 발급받기", "리유저블 활동", "플라스틱 프리", "플로깅", "리폼", "대중교통 자전거", "기타")
        val adapter = ArrayAdapter<String>(this, R.layout.spinner_dropdown_item, boardOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        boardSpinner.adapter = adapter

        val selectedBoard = intent.getStringExtra("selectedBoard")
        val position = boardOptions.indexOf(selectedBoard)
        if (position != -1) {
            // Set the Spinner selection
            boardSpinner.setSelection(position)
        }


        // 드롭다운 메뉴 선택 이벤트
        boardSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long,
            ) {
                // 선택한 게시판에 따라 필요한 처리 수행
                val selectedBoard = boardOptions[position]
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 때의 처리
            }
        }

        val checkPostingBtn = findViewById<Button>(R.id.checkPostingBtn)

        checkPostingBtn.setOnClickListener {
            // 포스팅 완료 버튼을 클릭할 때의 동작 정의
            // 데이터 서버로 넘기는 로직 필요

            finish()
            Toast.makeText(this,"완료되었습니다!",Toast.LENGTH_SHORT).show()
        }
    }

    // 이미지뷰를 클릭했을 때 다이얼로그 표시
    private fun showImageSourceDialog() {
        val options = arrayOf("갤러리에서 사진 가져오기", "사진 촬영 ")

        AlertDialog.Builder(this)
            .setTitle("이미지 업로드 옵션")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> openGallery()
                    1 -> openCamera()
                }
            }
            .show()
    }

    // 갤러리 열기
    private fun openGallery() {
        val galleryIntent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    // 카메라 열기
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent, TAKE_PICTURE_REQUEST)
    }

    // 갤러리 또는 카메라 선택 결과 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PICK_IMAGE_REQUEST -> {
                    // 갤러리에서 선택한 이미지 처리
                    val selectedImageUri: Uri? = data?.data
                    selectedImageUri?.let {
                        uploadedImages.add(it)
                        showUploadedImages()
                    }
                }

                TAKE_PICTURE_REQUEST -> {
                    // 카메라로 찍은 이미지 처리
                    // (이 부분은 디바이스의 실제 파일 경로로 이미지를 처리하는 로직이 필요합니다)
                }
            }
        }
    }

    // 업로드된 이미지를 UI에 나열
    private fun showUploadedImages() {
        val imageContainer = findViewById<LinearLayout>(R.id.image_container)
        imageContainer.removeAllViews()

        for (imageUri in uploadedImages) {
            val imageView = ImageView(this)
            imageView.layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.uploaded_image_size),
                resources.getDimensionPixelSize(R.dimen.uploaded_image_size)
            )

            // Glide를 사용하여 이미지 로드
            Glide.with(this)
                .load(imageUri)
                .into(imageView)

            imageContainer.addView(imageView)
        }
    }
}
