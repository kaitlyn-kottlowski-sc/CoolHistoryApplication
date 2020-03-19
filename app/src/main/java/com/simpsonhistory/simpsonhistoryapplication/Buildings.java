package com.simpsonhistory.simpsonhistoryapplication;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

class Buildings {


    final static String[] buildingNames = {"Wallace Hall", "Mary Berry", "Carver Hall", "College Hall",
            "Smith Memorial Chapel", "Hopper Gymnasium", "Cowles Fieldhouse and Carse Hall", "McNeill Hall", "Hillman Hall",
            "Blank Performing Arts Center", "Kent Campus Center", "Amy Robinson Music Center", "Pfieffer Dining and Great Hall",
            "Bill Buxton Stadium", "Dunn Library"};

    final static LatLng[] buildingLatLngs = {new LatLng(41.365068, -93.562963),
            new LatLng(41.365537, -93.564544),
            new LatLng(41.363742, -93.563243),
            new LatLng(41.364976, -93.563648),
            new LatLng(41.364191, -93.562678),
            new LatLng(41.365530, -93.565462),
            new LatLng(41.365907, -93.565964),
            new LatLng(41.364399, -93.564544),
            new LatLng(41.364231, -93.564044),
            new LatLng(41.365412, -93.567308),
            new LatLng(41.366596, -93.565547),
            new LatLng(41.364779, -93.562696),
            new LatLng(41.365849, -93.563772),
            new LatLng(41.364268, -93.565690),
            new LatLng(41.365502, -93.563619)
        };


    final static int[][] buildingInfo = {{R.string.wallaceHall, R.string.wallaceAuthor, R.drawable.wallace,  R.string.wallaceHistory, R.string.linkToWallace},
            {R.string.mary_berry,  R.string.maryAuthor, R.drawable.mary1,  R.string.maryHistoryPart1,R.drawable.mary2, R.string.maryHistoryPart2, R.string.linkToMary},
            { R.string.carver_hall,R.string.carverAuthor, R.drawable.carver_hall,  R.string.carverHistory, R.string.linkToCarver},
            {R.string.college_hall, R.string.collegeAuthor,R.drawable.college_hall,  R.string.collegeHistory, R.string.linkToCollege},
            {R.string.smithChapel, R.string.smithAuthor, R.drawable.smith,  R.string.smithHistory, R.string.linkToSmith},
            {R.string.hopper, R.string.hopperAuthor, R.drawable.hopper, R.string.hopperHistoryPart1,R.drawable.hopper2,   R.string.hopperHistoryPart2, R.string.linkToHopper},
            {R.string.cowles, R.string.cowlesAuthor,R.drawable.cowles,  R.string.cowlesHistory, R.string.linkToCowles},
            {R.string.mcneillHall, R.string.mcneillAuthor,R.drawable.mcneill, R.string.mcneillHistory, R.string.linkToMcNeill},
            {R.string.hillmanHall, R.string.hillmanAuthor, R.drawable.hillman1,  R.string.hillmanHistoryPart1, R.drawable.hillman2,  R.string.hillmanHistoryPart2, R.string.linkToHillman},
            {R.string.bpac, R.string.bpacAuthor,R.drawable.bpac,  R.string.bpacHistory, R.string.linkToBpac},
            {R.string.kent, R.string.kentAuthor,R.drawable.kent1, R.string.kentHistoryPart1, R.drawable.kent2,  R.string.kentHistoryPart2, R.string.linkToKent},
            {R.string.amyRobinson, R.string.amyAuthor,R.drawable.amy1, R.string.amyHistoryPart1, R.drawable.amy2,  R.string.amyHistoryPart2, R.string.linkToAmy},
            {R.string.pfieffer_great_hall, R.string.pfiefferAuthor,R.drawable.pfieffer_great_hall,  R.string.pfiefferHistory, R.string.linkToPfieffer},
            {R.string.buxton_stadium, R.string.billBuxtonAuthor, R.drawable.bill_buxton,  R.string.billBuxtonHistory, R.string.linkToBillBuxton},
            {R.string.dunn_library, R.string.dunnAuthor, R.drawable.dunn,  R.string.dunnHistory, R.string.linkToDunn}};

    final static String[] idNamesForOneImage = {"title", "author","image1", "history1", "link", "", ""};
    final static String[] idNamesForTwoImages = {"title", "author", "image1", "history1", "image2", "history2", "link"};

    final static int[] buildingButtonIDs = {R.id.wallaceButton, R.id.maryButton, R.id.carverButton, R.id.collegeButton,
            R.id.smithButton, R.id.hopperButton, R.id.cowlesButton, R.id.mcneillButton, R.id.hillmanButton, R.id.bpacButton, R.id.kentButton,
            R.id.amyButton, R.id.pfiefferButton, R.id.billBuxtonButton, R.id.dunnButton};

    static void setViewLocation(GoogleMap map)
    {
        // Zoom in vicinity of Simpson Campus
        final LatLng simpson = new LatLng(41.365475, -93.564849);
        final CameraUpdate newLoc = CameraUpdateFactory.newLatLngZoom(simpson, 17);
        map.animateCamera(newLoc);

    }

    static Marker[] getBuildingMarkers(GoogleMap map)
    {
        Marker[] buildingMarkers = new Marker[buildingNames.length];
        for(int i = 0; i < buildingNames.length; i++)
        {
            final Marker buildingMarker = map.addMarker(new MarkerOptions().position(buildingLatLngs[i]));
            buildingMarker.setTitle(buildingNames[i]);
            buildingMarker.setTag(buildingLatLngs[i]);
            buildingMarkers[i] = buildingMarker;
        }

        return buildingMarkers;
    }

}
