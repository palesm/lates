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

    export default {
        name: 'lates',
        components: {LateList, LateForm},
        methods: {
            generateLates() {
                this.$store.dispatch("generateLates")
                    .catch(error => {
                        console.log(error)
                    })
            },
        }
    }

</script>