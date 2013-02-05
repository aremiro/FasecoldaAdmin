package fasecoldaadmin

class Picture {

        String pictureId
        String url
        String secure_url
        String size_pic
        String max_size
        String quality

	static belongsTo = Version
}