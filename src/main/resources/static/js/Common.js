class Common{
    static showToastSuccess(msg){
        iziToast.success({
            displayMode: 'replace',
            position: "topRight",
            message: msg,
        });
    }

    static showToastError(msg){
        iziToast.error({
            displayMode: 'replace',
            position: "topRight",
            message: msg,
        });
    }
    static showToastInfo(msg){
        iziToast.show({
            theme: 'dark',
            position: "topRight",
            displayMode: 'replace',
            message: msg,
            progressBarColor: 'rgb(0, 255, 184)',
        });
    }

    static showToastCopyData(data){
        iziToast.info({
            timeout: 20000,
            close: false,
            overlay: true,
            displayMode: 'once',
            id: 'info',
            zindex: 999,
            title: 'Private Key: ',
            message: data,
            position: 'center',
            buttons: [
                ['<button><b>Copy</b></button>', function (instance, toast) {
                    Common.copy(data);
                    instance.hide({ transitionOut: 'fadeOut' }, toast, 'button');
                }, true]
            ]
        });
    }

    static copy(data){
        var sampleTextarea = document.createElement("textarea");
        document.body.appendChild(sampleTextarea);
        sampleTextarea.value = data; //save main text in it
        sampleTextarea.select(); //select textarea contenrs
        document.execCommand("copy");
        document.body.removeChild(sampleTextarea);
    }
}