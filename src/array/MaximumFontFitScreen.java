package array;


public class MaximumFontFitScreen {

    public static int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int lo = 0, hi = fonts.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            int fontsize = fonts[mid];
            if (sizeOk(text, fontsize, w, h, fontInfo) && (mid==fonts.length-1 || !sizeOk(text, fonts[mid+1], w, h, fontInfo))){
                return fontsize;
            }
            if (sizeOk(text, fontsize, w, h, fontInfo)){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static boolean sizeOk(String text, int fs, int h, int w, FontInfo fontInfo){
        if (fontInfo.getHeight(fs)>h){
            return false;
        }
        int totalWidth = 0;
        for (int i = 0; i < text.length();i++){
            totalWidth += fontInfo.getWidth(fs, text.charAt(i));
        }
        if (totalWidth>h){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FontInfo fi = new FontInfoImpl();
        String text = "helloworld";
        int w = 80, h = 20;
        int[] fonts = new int[]{6,8,10,12,14,16,18,24,36};
        //expected 6
        System.out.println(
                maxFont(text,w,h,fonts,fi)
        );
        String text2 = "leetcode";
        int w2 = 1000, h2 = 50;
        int[] fonts2 = new int[]{1,2,4};
        //expected 4
        System.out.println(
                maxFont(text2,w2,h2,fonts2,fi)
        );


    }


    interface FontInfo {
        // Returns the width of character ch on the screen using font size fontSize.
        // O(1) per call
        public int getWidth(int fontSize, char ch);

        // Returns the height of any character on the screen using font size fontSize.
        // O(1) per call
        public int getHeight(int fontSize);
    }

    static class FontInfoImpl implements FontInfo{

        @Override
        public int getWidth(int fontSize, char ch) {
            return fontSize;
        }

        @Override
        public int getHeight(int fontSize) {
            return 0;
        }
    }

}
