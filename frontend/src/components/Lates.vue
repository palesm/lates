<template>
    <div>
        <LateForm/>
        <button id="btnGen" @click.prevent="generateLates()" type="submit" class="btn btn-primary">Generate some late events</button>
        <LateList/>
    </div>
</template>

<script>
    import LateForm from "./LateForm";
    import LateList from "./LateList";
    import api from "./backend-api";
    export default {
        name: 'lates',
        components: {LateList, LateForm},
        methods: {
            generateLates() {
                api.generateLates()
            }
        }
    }

</script>