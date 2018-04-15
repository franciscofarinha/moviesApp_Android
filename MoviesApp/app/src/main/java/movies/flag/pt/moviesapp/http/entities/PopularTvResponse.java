package movies.flag.pt.moviesapp.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by franciscofarinha on 19/01/2018.
 */

public class PopularTvResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private ArrayList<PopularTv> popularTv = new ArrayList<>();

    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public ArrayList<PopularTv> getPopularTv() {

        return popularTv;
    }

}
