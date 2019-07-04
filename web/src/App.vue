<template>
    <div id="app">
        <div class="container">
          <router-view></router-view>
        </div>
        <notifications group="system" />
    </div>
</template>

<script>

export default {
    name: 'App'
}
</script>

<style lang="scss">
    @import "~bulma/css/bulma.css";
    #app {
        overflow-y: scroll;
        font-family: 'Museo Sans', 'Arial', 'Helvetica Neue', 'Helvetica', sans-serif;
        font-weight: 300;
        font-size: 16px;
    }

    .body-app {
        padding: 50px 0px;
    }

    @font-face {
        src: url(./assets/fonts/MuseoSans_100_normal.ff88c4ad284ba261a229a9c4f7e9fafd.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: normal;
        font-weight: 100;
        src: url(./assets/fonts/MuseoSans_100_normal.babf959a5ca2af08a8bbc4b922d66730.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_100_italic.f761c230651c192606a663450a5bdb2b.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: italic;
        font-weight: 100;
        src: url(./assets/fonts/MuseoSans_100_italic.2b5bf833f87882ec97b4925c29c782d4.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_300_normal.e76032feeed9724a2079d148c07a6ad8.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: normal;
        font-weight: 300;
        src: url(./assets/fonts/MuseoSans_300_normal.9ca14accae2a6b987bb5fc0000236572.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_300_italic.188d2f71dac839329f69f99141844fe0.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: italic;
        font-weight: 300;
        src: url(./assets/fonts/MuseoSans_300_italic.92c038ad48f7e9153ee6645444bbb40a.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_500_normal.0c2fa471a0bf99124096664a1bd6a040.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: normal;
        font-weight: 500;
        src: url(./assets/fonts/MuseoSans_500_normal.171ad3582ab0543d4ee818a476c26fd7.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_500_italic.69d9bb7a5461efc2df3769b86df854ca.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: italic;
        font-weight: 500;
        src: url(./assets/fonts/MuseoSans_500_italic.1cb18a77f8e5c3dc66fc8324e57f6e36.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_700_normal.3e002a90aa94f40e3070180559e0abc0.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: normal;
        font-weight: 700;
        src: url(./assets/fonts/MuseoSans_700_normal.8cd551a3e382a4db9aa3717cda06188e.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_700_italic.ef282e1138660377be5255812b4d868c.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: italic;
        font-weight: 700;
        src: url(./assets/fonts/MuseoSans_700_italic.93bed65273104b76966d475042a0c797.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_900_normal.6d752f5b705d5f71f6672b1e8de5eaba.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: normal;
        font-weight: 900;
        src: url(./assets/fonts/MuseoSans_900_normal.9178f1dc9d1339a5fb064bd80ad89697.woff);
    }
    @font-face {
        src: url(./assets/fonts/MuseoSans_900_italic.16c55ee979764c93a4d79f1824fd3303.woff2) format(woff2);
        font-family: Museo Sans;
        font-style: italic;
        font-weight: 900;
        src: url(./assets/fonts/MuseoSans_900_italic.8381584160d4f5f030704261226ed1cb.woff);
    }
</style>

